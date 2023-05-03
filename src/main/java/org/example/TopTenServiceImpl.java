package org.example;

import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopTenServiceImpl extends  TopTenServiceGrpc.TopTenServiceImplBase{
//    @Autowired
//    RatingRepository rr;
    @Override
    public void getTopTenMovies(EmptyRequest request, StreamObserver<TopTenMoviesResponse> responseObserver) {
        ArrayList<String> ids= new ArrayList<>();
        ArrayList<String>descriptions=new ArrayList<>();
        ArrayList<Float>ratings=new ArrayList<>();
        try{
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ratings","root","TimeLEPR1289$");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT movieID,AVG(rating) FROM user_ratings as r GROUP BY r.movieID ORDER BY AVG(rating) LIMIT 10");

            while(rs.next()) {
                ids.add(rs.getString(1));
                descriptions.add("");
                ratings.add(rs.getFloat(2));
            }
            con.close();
        }
        catch(Exception e){ System.out.println(e);}


        TopTenMoviesResponse topTenMoviesResponse = TopTenMoviesResponse.newBuilder().addAllName(ids).addAllDescription(descriptions).addAllRate(ratings).build();
        responseObserver.onNext(topTenMoviesResponse);
        responseObserver.onCompleted();
    }
}
