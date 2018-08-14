package hn.cch.entity;

/**
 * @author CCH
 * @version 2018.06.25.
 */


//客户来源
public class Source {


    public String sourceId;
    public String sourceName;


    public Source() {
        super();
    }

    public Source(String sourceId, String sourceName) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
