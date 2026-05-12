package org.elearning.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;



public class Payment {
    private Long id;
    private BigDecimal montant;
    private LocalDateTime date;
    private String status;
    private Long resourceId;

    public Payment() {
    }

    public Payment(Long id, BigDecimal montant, LocalDateTime date, String status) {
        this.id = id;
        this.montant = montant;
        this.date = date;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", montant=" + montant +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", resourceId=" + resourceId +
                '}';
    }
}
