package com.hxb.oldBook.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "apply_for_business")
public class ApplyForBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 申请人姓名
     */
    @Column(name = "apply_person_name")
    private String applyPersonName;

    /**
     * 审批状态  0-未审批 1-审批通过 2-审批不通过
     */
    private Short status;

    /**
     * 申请原因
     */
    @Column(name = "apply_reason")
    private String applyReason;

    /**
     * 回执信息
     */
    @Column(name = "return_message")
    private String returnMessage;

    /**
     * 申请成为商家的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "apply_time")
    private Date applyTime;

    /**
     * 管理员审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "approval_time")
    private Date approvalTime;

    /**
     * 该条记录是否可用 0-不可用 1-可用
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * 申请成为商家的用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取申请人姓名
     *
     * @return apply_person_name - 申请人姓名
     */
    public String getApplyPersonName() {
        return applyPersonName;
    }

    /**
     * 设置申请人姓名
     *
     * @param applyPersonName 申请人姓名
     */
    public void setApplyPersonName(String applyPersonName) {
        this.applyPersonName = applyPersonName == null ? null : applyPersonName.trim();
    }

    /**
     * 获取审批状态  0-未审批 1-审批通过 2-审批不通过
     *
     * @return status - 审批状态  0-未审批 1-审批通过 2-审批不通过
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置审批状态  0-未审批 1-审批通过 2-审批不通过
     *
     * @param status 审批状态  0-未审批 1-审批通过 2-审批不通过
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取申请原因
     *
     * @return apply_reason - 申请原因
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * 设置申请原因
     *
     * @param applyReason 申请原因
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason == null ? null : applyReason.trim();
    }

    /**
     * 获取回执信息
     *
     * @return return_message - 回执信息
     */
    public String getReturnMessage() {
        return returnMessage;
    }

    /**
     * 设置回执信息
     *
     * @param returnMessage 回执信息
     */
    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage == null ? null : returnMessage.trim();
    }

    /**
     * 获取申请成为商家的时间
     *
     * @return apply_time - 申请成为商家的时间
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 设置申请成为商家的时间
     *
     * @param applyTime 申请成为商家的时间
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 获取管理员审批时间
     *
     * @return approval_time - 管理员审批时间
     */
    public Date getApprovalTime() {
        return approvalTime;
    }

    /**
     * 设置管理员审批时间
     *
     * @param approvalTime 管理员审批时间
     */
    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    /**
     * 获取该条记录是否可用 0-不可用 1-可用
     *
     * @return is_active - 该条记录是否可用 0-不可用 1-可用
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * 设置该条记录是否可用 0-不可用 1-可用
     *
     * @param isActive 该条记录是否可用 0-不可用 1-可用
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * 获取申请成为商家的用户id
     *
     * @return user_id - 申请成为商家的用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置申请成为商家的用户id
     *
     * @param userId 申请成为商家的用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}