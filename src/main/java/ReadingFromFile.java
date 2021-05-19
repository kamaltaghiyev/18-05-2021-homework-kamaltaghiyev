import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ReadingFromFile {
    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("sample.txt"));
        List<String> linesOnlyText = new ArrayList<>();
        List<Integer> linesOnlyNumbers = new ArrayList<>();
        List<String> linesDates = new ArrayList<>();
        List<String> linesNumbersAndText = new ArrayList<>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            if (Pattern.matches("[a-zA-Z]+\\s*[a-zA-Z]*", line)) {
                linesOnlyText.add(line);

            } else if (Pattern.matches("[0-9]+", line)) {
                int b1 = Integer.parseInt(line);
                linesOnlyNumbers.add(b1);
            } else if (Pattern.matches("\\d{2}\\.\\d{2}\\.\\d{4}\\s\\d{2}[:]\\d{2}[:]\\d{2}$", line)) {
                linesDates.add(line);
            } else if (Pattern.matches("\\d{2}[A-Z]{2}\\d{3}", line)) {

                linesNumbersAndText.add(line);
            }


        }
        Collections.sort(linesOnlyText, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(linesOnlyNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }

        });

        Collections.sort(linesDates, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });


        Collections.sort(linesNumbersAndText, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o2.substring(2).compareTo(o1.substring(2)) == 0) {
                    if (o2.substring(3).compareTo(o1.substring(3)) == 0) {
                        if (o2.substring(0).compareTo(o1.substring(0)) == 0) {
                            if (o2.substring(1).compareTo(o1.substring(1)) == 0) {
                                if (o2.substring(4).compareTo(o1.substring(4)) == 0) {
                                    if (o2.substring(5).compareTo(o1.substring(5)) == 0) {
                                        if (o2.substring(6).compareTo(o1.substring(6)) == 0) {
                                            return o2.substring(6).compareTo(o1.substring(6));
                                        } else {
                                            return o2.substring(6).compareTo(o1.substring(6));
                                        }
                                    } else {
                                        return o2.substring(5).compareTo(o1.substring(5));
                                    }
                                } else {
                                    return o2.substring(4).compareTo(o1.substring(4));
                                }
                            } else {
                                return o2.substring(1).compareTo(o1.substring(1));
                            }
                        } else {
                            return o2.substring(0).compareTo(o1.substring(0));
                        }
                    } else {
                        return o2.substring(3).compareTo(o1.substring(3));
                    }
                } else {
                    return o2.substring(2).compareTo(o1.substring(2));
                }
            }
        });
        bufferedReader.close();
        try {

            FileWriter onlyDigits = new FileWriter("OnlyDigits.txt");
            Writer output1 = new BufferedWriter(onlyDigits);
            int size = linesOnlyNumbers.size();
            for (int i = 0; i < size; i++) {
                output1.write(linesOnlyNumbers.get(i).toString() + "\n");
            }
            output1.close();

        FileWriter onlyText = new FileWriter("OnlyText.txt");
        Writer output2 = new BufferedWriter(onlyText);
        size = linesOnlyText.size();
        for (int i = 0; i < size; i++) {
            output2.write(linesOnlyText.get(i).toString() + "\n");
        }
        output2.close();

            FileWriter onlyDates = new FileWriter("OnlyDates.txt");
            Writer output3 = new BufferedWriter(onlyDates);
             size = linesDates.size();
            for (int i = 0; i < size; i++) {
                output3.write(linesDates.get(i).toString() + "\n");
            }
            output3.close();
            FileWriter carNumbers = new FileWriter("CarNumber.txt");
            Writer output4 = new BufferedWriter(carNumbers);
            size = linesNumbersAndText.size();
            for (int i = 0; i < size; i++) {
                output4.write(linesNumbersAndText.get(i).toString() + "\n");
            }
            output4.close();

    }catch(Exception e) {
        System.out.println(e);
    }
    }


}