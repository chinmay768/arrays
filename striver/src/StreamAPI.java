import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {

    class Employee {
        String name;
        String city;
        Integer age;
        Double salary;

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();


        list.stream().filter(emp -> emp.getAge() > 20).map(emp -> emp.getName()).toList();

        // Get Distict City
        list.stream().map(emp -> emp.getCity()).distinct().forEach(System.out::println);


        // Count employees whose salary is greater than 20K
        Long count = list.stream().filter(emp -> emp.getSalary() > 20000).count(); // Returns Long


        // Get first 3 entries
        List<Employee> empList = list.stream().limit(3).toList();


        // Skip First 3 Employees
        List<Employee> employeeList = list.stream().skip(3).toList();

        // Any one employee < 18 (atleast one match)
        Boolean isPresent = list.stream().anyMatch(emp -> emp.getAge() < 18);

        // Check if every employee > 18 or not
        Boolean isPresent2 = list.stream().allMatch(emp -> emp.getAge() > 18);

        // Check if every employee >=  18 // returns true if ever emp is false
        Boolean isPresent3 = list.stream().noneMatch(emp -> emp.getAge() < 18);

        // Get any one value from the stream
        Employee emp1 = list.stream().findAny().get(); // Return any random value

        // Get first elm
        Employee emp2 = list.stream().findFirst().get();

        // Sorted
        List<Integer> sortedEmpIds = list.stream().map(emp -> emp.getAge()).sorted().toList();

        // Sort based on Age
        List<Employee> sortedEmpList = list.stream().sorted((a, b) -> a.getAge() - b.getAge()).toList();

        // Sort Desc
        List<Employee> sortedEmpListdesc = list.stream().sorted((a, b) -> b.getAge() - a.getAge()).toList();

        // Sort Strings   "a".compareTo("b") = -1;     compareToIgnoreCase
        List<String> sortedStrings = list.stream().map(emp -> emp.getName()).sorted((n1, n2) -> n1.compareTo(n2)).toList();

        // Get the max age employee
        Employee maxSalaryEmp = list.stream().max(Comparator.comparingInt(emp -> emp.getAge())).get();

        // Get avg salary of employees
        Double avg = list.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble(); // average returns OptionalDouble

        // Get avg age of employees
        Double avgAge = list.stream().mapToInt(emp -> emp.getAge()).average().getAsDouble(); // average returns OptionalDouble


        LocalDate cutoffDate = LocalDate.of(2015, 6, 1);
        // Find Employees who have joined after 2015-06-01
        List<Employee> filteredEmployees = list.stream()
                .filter(emp -> emp.getJoiningDate().isAfter(cutoffDate))
                .collect(Collectors.toList());

        // Peek  It is just an intermediate oprtn which doesn't modify the actual stream data
        List<Employee> empDetails = list.stream().peek(System.out::println).filter(elm -> elm.salary > 2000).toList();

        // Find employee names whose age is greater than 25
        List<String> empNames = list.stream().filter(emp -> emp.age > 25).map(Employee::getName).collect(Collectors.toList());

        // Unique City
        List<String> dept = list.stream().map(emp -> emp.getCity()).distinct().toList();
        Set<String> dept2 = list.stream().map(emp -> emp.getCity()).collect(Collectors.toSet());

        // Collect employee Ids and their salaries as map
        Map<String, Double> res = list.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));

        // get avg salary of each dept
        Map<String, Double> res2 = list.stream().collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.averagingDouble(Employee::getSalary)
        ));


        // Get count of employees city wise
        Map<String, Long> countOfEmpCitywise = list.stream().collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.counting()
        ));

        // get all emp salary sum
        Double sum = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
    }

    public void streamQues( ){
        String s = "I am learning java streams";
        int[] arr = {1, 2, 3, 4, 5};
        // Given a sentence, find the word that has the highest length
         String maxLenStr = Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get();

        // Remove duplicates and reurn in same order S = "dabcadefg"  -> S = "dabcefg"
        Arrays.stream(s.split("")).distinct().collect(Collectors.joining());

        //Find the word that has the second highest length
        String str1 = Arrays.stream(s.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();

        str1 =  Arrays.stream(s.split(" ")).sorted((w1, w2) -> Integer.compare(w2.length(), w1.length())).skip(1).findFirst().get();

        // Find the 2nd highest length word in the given sentence
        int len = Arrays.stream(s.split(" ")).map(word -> word.length()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        // Given a sentence, find the occurrence of each word
        Map<String, Long> wordFrequency = Arrays.stream(s.trim()
                        .replaceAll("[^a-zA-Z0-9\\s]", "")//remove punctuation using regex
                        .split("\\s+"))// removing extra space
                .map(String::toLowerCase)// converting to lowerCase
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        wordFrequency = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Given a sentence, find the words with a specified number of vowels
        List<String> words = Arrays.stream(s.split(" ")).filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2).collect(Collectors.toList());

        //Divide given integer list into lists of even and odd numbers
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()));

        List<List<Integer>> list2 = list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList())).entrySet().stream()
                .map(x -> x.getValue()).collect(Collectors.toList());

        map = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i%2 == 1));
        //System.out.println("Odd numbers: " + map.get(true));   // [1, 3, 5]
        //System.out.println("Even numbers: " + map.get(false)); // [2, 4]

        // Convert arrayToList
        int[] arr2 = list.stream().mapToInt(Integer::intValue).toArray();

        //  Given a word, find the occurrence of each character
        String str = "omprogramming";
        Map<String, Long> charOccurence = Arrays.stream(str.split("")).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Arrange the int[] numbers in Descending/Ascending Order
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        int[] sortedDesc = Arrays.stream(arr) // Give IntStream
                .boxed() // Mandatory to use comparator in sorted() Converts IntStream to Stream<Integer>
                .sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();


        // Given an array, find the sum of unique elements
        int sum = Arrays.stream(arr).distinct().sum();

        //  Given a string, find the first non-repeated character
        String unique = Arrays.stream(s.split("")).filter(c -> str.indexOf(c) == str.lastIndexOf(c)).findFirst().get();


        // Given a string, find the first repeated character
        Map<Character, Long> charmap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                LinkedHashMap::new, Collectors.counting())); // LinkedHashMap preserves the order of string

        char ans =  charmap.entrySet().stream().filter(m -> m.getValue() > 1).map(m -> m.getKey()).findFirst().get();

        // Alternate soln
        Set<Character> seen = new HashSet<>();

        Optional<Character> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c)) // if already present, it's repeated
                .findFirst();



        // Given an array of integers, group the numbers by the range
        Map<Integer, List<Integer>> rangeGroup = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(x -> (x / 10) * 10, Collectors.toList()));


        // Given a list of strings, create a list that contains only integers
        List<String> strList = Arrays.asList("10", "abc", "25", "42", "xyz", "100");
        List<Integer> integers = strList.stream()
                .filter(st -> st.matches("-?\\d+")) // regex to allow optional negative sign followed by digits
                .map(Integer::parseInt).collect(Collectors.toList());


        // Find the products of the first two elements in an array
        int product = Arrays.stream(arr).limit(2).reduce(1, (a, b) -> a * b);

        // Group /Pair anagrams from a list of Strings
        Map<String, List<String>> anagram = strList.stream().collect(Collectors.groupingBy(
                x-> Arrays.stream(x.toLowerCase().split("")).sorted().collect(Collectors.joining()),
                Collectors.toList()
        ));


        // Write a stream program to multiply odd index numbers in an array
        int product2 = IntStream.range(0, arr.length).filter(i -> i % 2 == 1).map(i -> arr[i]).reduce(1, (a, b) -> a * b);

        // Write a program to multiply 1st and last element, 2nd and 2nd last element etc
        int[] result2 = IntStream.range(0,  arr.length / 2).map(x -> arr[x] * arr[arr.length - x - 1]).toArray();

        //Write a stream program to move all zero’s to the beginning of array using java streams
        List<Integer> result3 = Stream.concat(
                Arrays.stream(arr).boxed().filter(x -> x == 0),        // zeros first
                Arrays.stream(arr).boxed().filter(x -> x != 0)         // then non-zeros
        ).collect(Collectors.toList());
    }
}
































