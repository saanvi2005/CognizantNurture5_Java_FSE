public class SearchProducts {

    static String[] products = {"Apple", "Banana", "Camera", "Dell Laptop", "Earphones", "Fan", "GPU"};

    // linear search - checks one by one
    static int linearSearch(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    // binary search - array has to be sorted
    static int binarySearch(String[] arr, String target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareToIgnoreCase(target);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String search1 = "Fan";
        String search2 = "Monitor";

        int res1 = linearSearch(products, search1);
        System.out.println("Linear Search for '" + search1 + "': " + (res1 != -1 ? "Found at index " + res1 : "Not found"));

        int res2 = binarySearch(products, search1);
        System.out.println("Binary Search for '" + search1 + "': " + (res2 != -1 ? "Found at index " + res2 : "Not found"));

        int res3 = linearSearch(products, search2);
        System.out.println("Linear Search for '" + search2 + "': " + (res3 != -1 ? "Found at index " + res3 : "Not found"));

        int res4 = binarySearch(products, search2);
        System.out.println("Binary Search for '" + search2 + "': " + (res4 != -1 ? "Found at index " + res4 : "Not found"));
    }
}
