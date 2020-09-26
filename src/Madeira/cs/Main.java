package Madeira.cs;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    /*
    Author: Ellie Zhou
    Date: September 24th
     */

    public static <artists> void main(String[] args) {
        try {
            File myObj = new File("/Users/elliezhou/Desktop/artistList.txt");
            Scanner myReader = new Scanner (myObj);
            int numArtists = myReader.nextInt();
            String temporary = myReader.nextLine();
            String[] artist = new String[numArtists];
            int counter=0;
            while (myReader.hasNextLine()) {
                artist[counter] = myReader.nextLine();
                counter++;
            }
            myReader.close();
            Artist [] artists = new Artist [numArtists];
            counter=0;
            for(String line: artist){
                artists[counter] = new Artist();
                artists[counter].setName(line.split(",")[0]);
                artists[counter].setAlbum(line.split(",")[1]);
                artists[counter].setTwitterHandle(line.split(",")[2]);
                counter++;
            }
            Scanner rate1 = new Scanner(System.in);
            counter = 0;
            for(Artist line: artists){
                System.out.println("Please rate "+ line.getName() +" from one to ten.");
                int rating = rate1.nextInt();
                artists[counter].setRating(rating);
                counter++;
            }
            counter = 0;
            for(Artist line: artists){
                System.out.println(""+line.getName()+
                        " has an album named"+line.getAlbum()+
                        "\n Her/his twitterHandle is"+line.getTwitterHandle()+
                        "\n Her/his rate is "+artists[counter].getRating());
                counter++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred");
            e.printStackTrace();
            }
        }
     }
        class Artist{

            String name;
            String album;
            String twitterHandle;
            int rating;

            public Artist () {
                name = "N/A";
                album = "N/A";
                twitterHandle = "N/A";
                rating = 0;
    }
        public void setName (String newName) { name = newName;}
        public String getName () {return name;}
        public void setAlbum (String newAlbum) { album = newAlbum;}
        public String getAlbum () {return album; }
        public void setTwitterHandle (String newTwitterHandle) { twitterHandle = newTwitterHandle;}
        public String getTwitterHandle () {return twitterHandle;}
        public void setRating (int newRating) { rating = newRating;}
        public int getRating () {return rating; }


	// write your code here
}

