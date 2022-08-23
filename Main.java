package com.hellowworld;

import java.util.List;

public class Main {
    public static void main (String[]args){

        Datasource datasource=new Datasource();
        if(!datasource.open()){
            System.out.println("can't " +
                    "open datasource");
            return;
        }
         List<Artist> artists=datasource.queryArtists(Datasource.ORDER_BY_ASC);
        if(artists==null){
            System.out.println("No artist !");
            return;
        }
        for(Artist artist :artists){
            System.out.println("ID = "+artist.getId()+", Name = "+artist.getName());
        }

        List<String> albumsForArtists1=
                Datasource.queryAlbumsForArtist("Iron Maiden",Datasource.ORDER_BY_ASC);
        for(String album: albumsForArtists1){
            System.out.println(album);
        }


         datasource.close();
    }

}
