package com.hxb.oldBook.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "apply_for_business")
public class ApplyForBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 审批状态
     */
    private Short status;

    /**
     * 回执信息
     */
    @Column(name = "return_message")
    private String returnMessage;

    /**
     * 申请成为商家的时间
     */
    @Column(name = "apply_time")
    private Date applyTime;

    /**
     * 管理员审批时间
     */
    @Column(name = "approval_time")
    private Date approvalTime;

    /**
     * 申请成为商家的用户id
     */
    @Column(name = "user_id")
    private Long userId;

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
     * 获取审批状态
     *
     * @return status - 审批状态
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置审批状态
     *
     * @param status 审批状态
     */
    public void setStatus(Short status) {
        this.status = status;
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
     * 获取申请成为商家的用户id
     *
     * @return user_id - 申请成为商家的用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置申请成为商家的用户id
     *
     * @param userId 申请成为商家的用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}