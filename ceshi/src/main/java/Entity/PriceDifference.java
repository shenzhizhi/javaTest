package Entity;

/**
 * his与pacs相同检查项目的价格比较
 */
public class PriceDifference {
    public String EXAM_CLASS;
    public String EXAM_SUB_CLASS;
    public String ITEM_CODE;
    public String ITEM_NAME;
    public double PACS_PRICE;
    public double HIS_PRICE;

    public PriceDifference(String EXAM_CLASS, String EXAM_SUB_CLASS, String ITEM_CODE, String ITEM_NAME, double PACS_PRICE, double HIS_PRICE) {
        this.EXAM_CLASS = EXAM_CLASS;
        this.EXAM_SUB_CLASS = EXAM_SUB_CLASS;
        this.ITEM_CODE = ITEM_CODE;
        this.ITEM_NAME = ITEM_NAME;
        this.PACS_PRICE = PACS_PRICE;
        this.HIS_PRICE = HIS_PRICE;
    }

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

    public double getPACS_PRICE() {
        return PACS_PRICE;
    }

    public void setPACS_PRICE(double PACS_PRICE) {
        this.PACS_PRICE = PACS_PRICE;
    }

    public double getHIS_PRICE() {
        return HIS_PRICE;
    }

    public void setHIS_PRICE(double HIS_PRICE) {
        this.HIS_PRICE = HIS_PRICE;
    }

    @Override
    public String toString() {
        return "PriceDifference{" +
                "EXAM_CLASS='" + EXAM_CLASS + '\'' +
                ", EXAM_SUB_CLASS='" + EXAM_SUB_CLASS + '\'' +
                ", ITEM_CODE='" + ITEM_CODE + '\'' +
                ", ITEM_NAME='" + ITEM_NAME + '\'' +
                ", PACS_PRICE=" + PACS_PRICE +
                ", HIS_PRICE=" + HIS_PRICE +
                '}';
    }
}
