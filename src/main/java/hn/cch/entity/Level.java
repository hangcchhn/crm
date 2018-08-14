package hn.cch.entity;

/**
 * @author CCH
 * @version 2018.06.25.
 */


//客户级别
public class Level {


    public String levelId;
    public String levelName;

    public Level() {
        super();
    }

    public Level(String levelId, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

}
