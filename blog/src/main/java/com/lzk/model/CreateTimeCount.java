package com.lzk.model;

/**
 * Created by lzk on 2018/2/12 22:06
 * Description:
 */
public class CreateTimeCount {
    private String createTime;
    private Integer count;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CreateTimeCount{" +
                "createTime='" + createTime + '\'' +
                ", count=" + count +
                '}';
    }
}
