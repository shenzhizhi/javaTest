package Entity;

/**
 * 存放A比B的检查项目实体
 */
public class Item {
    public String EXAM_CLASS;
    public String EXAM_SUB_CLASS;
    public String ITEM_CODE;
    public String ITEM_NAME;
    public double COST;

    public String getEXAM_CLASS() {
        return EXAM_CLASS;
    }

    public void setEXAM_CLASS(String EXAM_CLASS) {
        this.EXAM_CLASS = EXAM_CLASS;
    }

    public String getEXAM_SUB_CLASS() {
        return EXAM_SUB_CLASS;
    }

    public void setEXAM_SUB_CLASS(String EXAM_SUB_CLASS) {
        this.EXAM_SUB_CLASS = EXAM_SUB_CLASS;
    }

    public String getITEM_CODE() {
        return ITEM_CODE;
    }

    public void setITEM_CODE(String ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public double getCOST() {
        return COST;
    }

    public void setCOST(double COST) {
        this.COST = COST;
    }

    @Override
    public String toString() {
        return "Item{" +
                "EXAM_CLASS='" + EXAM_CLASS + '\'' +
                ", EXAM_SUB_CLASS='" + EXAM_SUB_CLASS + '\'' +
                ", ITEM_CODE='" + ITEM_CODE + '\'' +
                ", ITEM_NAME='" + ITEM_NAME + '\'' +
                ", COST=" + COST +
                '}';
    }
}