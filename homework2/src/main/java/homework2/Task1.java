package homework2;

/*
1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class Task1 {
    public static void main(String[] args) {
        String input = "{\"name\":\"null\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"8\"}".trim();

        String[] parts = input.substring(1, input.length() - 1).split(",");
        String[] fields = new String[parts.length];
        String[] values = new String[parts.length];
        int ageIndex = -1;
        boolean hasValue = false;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            String[] temp = part.trim().split(":");
            String field = removeQuotes(temp[0]);
            if ("age".equals(field)) {
                ageIndex = i;
            }
            fields[i] = field;
            String value = removeQuotes(temp[1]);
            if (!"null".equals(value)) {
                values[i] = value;
                hasValue = true;
            }
        }
        if (!hasValue) {
            System.out.println("нет значений");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("WHERE ");
        boolean appended = false;
        for (int i = 0; i < fields.length; i++) {
            String value = values[i];
            if (value == null) {
                continue;
            }
            if (i > 0 && appended) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append(fields[i]).append("=");
            if (i != ageIndex) {
                stringBuilder.append("'");
            }
            stringBuilder.append(value);
            if (i != ageIndex) {
                stringBuilder.append("'");
            }
            appended = true;
        }
        System.out.println(stringBuilder);
    }

    private static String removeQuotes(String input) {
        return input.trim().replace("\"", "");
    }


}
