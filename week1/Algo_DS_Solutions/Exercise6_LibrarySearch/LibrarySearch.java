public class LibrarySearch {

    static String[] books = {
        "Anna Karenina",
        "Brave New World",
        "Crime and Punishment",
        "Don Quixote",
        "Emma",
        "Frankenstein",
        "Great Expectations"
    };

    static int linearSearch(String[] arr, String title) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(String[] arr, String title) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int c = arr[mid].compareToIgnoreCase(title);
            if (c == 0) return mid;
            else if (c < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String t1 = "Emma";
        String t2 = "Moby Dick";

        System.out.println("Searching for: " + t1);
        int r = linearSearch(books, t1);
        System.out.println("Linear: " + (r >= 0 ? "Found at index " + r : "Not found"));
        r = binarySearch(books, t1);
        System.out.println("Binary: " + (r >= 0 ? "Found at index " + r : "Not found"));

        System.out.println("\nSearching for: " + t2);
        r = linearSearch(books, t2);
        System.out.println("Linear: " + (r >= 0 ? "Found at index " + r : "Not found"));
        r = binarySearch(books, t2);
        System.out.println("Binary: " + (r >= 0 ? "Found at index " + r : "Not found"));
    }
}
