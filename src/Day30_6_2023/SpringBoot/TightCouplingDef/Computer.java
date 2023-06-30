package Day30_6_2023.SpringBoot.TightCouplingDef;


// Khái niệm tight-coupling (liên kết ràng buộc)
// và cách nới lỏng tính ràng buộc đó.
// Vd: Khi khởi động máy tính, người dùng chọn chức năng
//     sorter và được phép chọn nhiều thuật toán sort khác nhau.
//     Nếu như gắn cố định một thuật toán vào chức năng sorter,
//     thì khi muốn sửa, xóa, thêm, bớt thuật toán, thì ta sẽ phải
//     sửa cả hai class sorter và class thuật toán.
//     Như vậy, mục đích là làm giảm tính phụ thuộc giữa các
//     class với nhau.
//     Ở đây, cái máy tính bắt buộc phải dùng chức năng sorter để
//     thực hiện nhiệm vụ -> khi class sorter thêm chức năng thì
//     class computer cũng có thể gọi thêm được chức năng đó. -> không thể nới lỏng tính ràng buộc.
//     Còn class Sorter thì ta có thể áp dụng tính lỏng lẻo để class sorter
//     có thể sử dụng nhiều loại thuật toán khác nhau bằng
//     cách tạo một lớp giao diện SortAlgorithm và để các lớp Algorithm
//     implement giao diện đó. -> Tùy thuộc vào chức năng của từng lớp
//     ta có thể tối thiểu hóa tính ràng buộc để có thể dễ gọi và sửa.

//This is a computer
//It will use sorter to sort an array
public class Computer {
    public static void main(String[] args) {
        int[] array = new int[3];
        SortAlgorithm mergeSortAlgorithm = new BubblesortAlgo();
        SortAlgorithm quickSortAlgorithm = new QuicksortAlgo();
        Sorter main1 = new Sorter(mergeSortAlgorithm);
        main1.sort(array);
        Sorter main2 = new Sorter(quickSortAlgorithm);
        main2.sort(array);
    }
}

//Sorter will use SortAlgorithm interface to
class Sorter{
    private SortAlgorithm sortAlgorithm;
    public Sorter(SortAlgorithm sortAlgorithm){
        this.sortAlgorithm = sortAlgorithm;
    }
    public void sort(int[] array) {
        sortAlgorithm.sort(array);
    }
}

// This is a SortAlgorithm Interface
interface SortAlgorithm {
    public void sort(int[] array);
}

// These are different sort Algorithm
// Quick Sort
class QuicksortAlgo implements SortAlgorithm{
    @Override
    public void sort(int[] array) {
        System.out.println("Have sorted successfully by Quicksort");
    }
}
// Bubble Sort
class BubblesortAlgo implements  SortAlgorithm{
    @Override
    public void sort(int[] array) {
        System.out.println("Have sorted successfully by Mergesort");
    }
}

