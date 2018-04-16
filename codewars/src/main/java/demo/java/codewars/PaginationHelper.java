package demo.java.codewars;

import java.util.List;

/**
 * @param <I>
 *     https://www.codewars.com/kata/515bb423de843ea99400000a
 */
public class PaginationHelper<I> {

    private List<I> collection;
    private int size;
    private int total;
    private int pages;
    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.size = itemsPerPage;

        this.total = collection.size();
        this.pages = (this.total + size - 1) / this.size;


    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return total;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pages;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex > this.pages - 1) {
            return -1;
        } else if (pageIndex == this.pages -1) {
            return this.total % size;
        }
        return size;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (this.total == 0 || itemIndex > this.total || itemIndex < 0) {
            return -1;
        }
        return itemIndex / this.size;
    }
}
