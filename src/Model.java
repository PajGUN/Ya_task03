import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Model {

    public static void main(String[] args) {
        List<Rating> ratings = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> mapDocument = new HashMap<>();

        URL url = Thread.currentThread().getContextClassLoader().getResource("resources/data_task3.csv");
//        try (BufferedReader reader = new BufferedReader(new FileReader("c:/tmp/data_task3.csv"))) {
        try (BufferedReader reader = new BufferedReader(new FileReader(url.getFile()))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null){
                Rating rating = new Rating();
                String[] strings = line.split("\t");
                rating.setLogin(strings[0]);
                rating.setUserId(Integer.valueOf(strings[1]));
                rating.setDocumentId(Integer.valueOf(strings[2]));
                rating.setJudgement(Integer.valueOf(strings[3]) != 0);
                rating.setJudgementCorrect(Integer.valueOf(strings[4]) != 0);
                ratings.add(rating);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Rating rating : ratings){
            if (rating.isJudgementCorrect() != rating.isJudgement()){
                if (map.containsKey(rating.getUserId())){
                    map.put(rating.getUserId(),map.get(rating.getUserId())+1);
                }
                else {
                    map.put(rating.getUserId(),1);
                }
            }
        }
/*        for (Rating rating : ratings){
            if (rating.isJudgementCorrect() != rating.isJudgement()){
                if (mapDocument.containsKey(rating.getDocumentId())){
                    mapDocument.put(rating.getDocumentId(),mapDocument.get(rating.getDocumentId())+1);
                }
                else {
                    mapDocument.put(rating.getDocumentId(),1);
                }
            }
        }*/
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach((i)-> System.out.println("UserID="+i.getKey()+"\t Errors="+i.getValue()));


/*        mapDocument.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach((i)-> System.out.println("DocumentID="+i.getKey()+"\t Errors="+i.getValue()));*/
    }
}