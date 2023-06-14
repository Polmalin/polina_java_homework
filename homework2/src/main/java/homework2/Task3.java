package homework2;

//3) Дана json-строка (можно сохранить в файл и читать из файла)
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
//        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//        Студент [фамилия] получил [оценка] по предмету [предмет].
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика
public class Task3 {
    public static void main(String[] args) {
        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},\n" +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},\n" +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        StudentInfo[] studentInfos = parseStudentInfos(json);
        StringBuilder stringBuilder = new StringBuilder();
        for (StudentInfo studentInfo : studentInfos) {
            stringBuilder.append("Студент ").append(studentInfo.lastName)
                    .append(" получил ").append(studentInfo.mark)
                    .append(" по предмету ").append(studentInfo.subject)
                    .append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static StudentInfo[] parseStudentInfos(String json) {
        int count = 0;
        for (int i = 0; i < json.length(); i++) {
            if (json.charAt(i) == '}') {
                count++;
            }
        }
        StudentInfo[] studentInfos = new StudentInfo[count];
        int lastIndex = 0;
        for (int i = 0; i < studentInfos.length; i++) {
            int fromIndex = json.indexOf("{", lastIndex) + 1;
            lastIndex = json.indexOf("}", fromIndex);
            studentInfos[i] = parseStudentInfo(json.substring(fromIndex, lastIndex));
        }
        return studentInfos;
    }

    private static StudentInfo parseStudentInfo(String input) {
        String[] parts = input.substring(1, input.length() - 1).split(",");
        String[] fields = new String[parts.length];
        String[] values = new String[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            String[] temp = part.trim().split(":");
            String field = removeQuotes(temp[0]);
            fields[i] = field;
            String value = removeQuotes(temp[1]);
            if (!"null".equals(value)) {
                values[i] = value;
            }
        }
        StudentInfo studentInfo = new StudentInfo();
        for (int i = 0; i < fields.length; i++) {
            switch (fields[i]) {
                case "фамилия":
                    studentInfo.lastName = values[i];
                    break;
                case "оценка":
                    studentInfo.mark = Integer.parseInt(values[i]);
                    break;
                case "предмет":
                    studentInfo.subject = values[i];
                    break;
            }
        }
        return studentInfo;
    }

    private static String removeQuotes(String input) {
        return input.trim().replace("\"", "");
    }

}
