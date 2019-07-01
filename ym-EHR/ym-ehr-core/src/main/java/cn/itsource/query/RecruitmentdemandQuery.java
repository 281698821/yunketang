package cn.itsource.query;

import cn.itsource.dto.RecruitmentdemandDto;

public class RecruitmentdemandQuery {
    private Integer state;
    private Integer begin;
    private Integer end;
    private RecruitmentdemandDto recruitmentdemandDto;



    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public RecruitmentdemandDto getRecruitmentdemandDto() {
        return recruitmentdemandDto;
    }

    public void setRecruitmentdemandDto(RecruitmentdemandDto recruitmentdemandDto) {
        this.recruitmentdemandDto = recruitmentdemandDto;
    }

    @Override
    public String toString() {
        return "RecruitmentdemandQuery{" +
                "state=" + state +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}