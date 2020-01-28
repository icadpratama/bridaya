package team.kasta.bridaya.util;

public class PageAndSortModel {
    int page;
    int size;
    String direction;
    String column;

    public PageAndSortModel(int page, int size, String direction, String column) {
        this.page = page;
        this.size = size;
        this.direction = direction;
        this.column = column;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
}
