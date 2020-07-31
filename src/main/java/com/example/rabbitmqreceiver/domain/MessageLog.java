package com.example.rabbitmqreceiver.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class MessageLog implements Serializable {
  @Id
  private String MessageId;
  @Column(nullable = false)
  private String TenantID;
  @Column(nullable = false)
  private String ProcessStage;
  @Column(nullable = false)
  private String ProcessStageStatus;
  @Column(nullable = false)
  private String ExternalTransmission;
  @Column(nullable = false)
  private String InternalTransmission;
  @Column(nullable = false)
  private String SelfBillingDocument;
  @Column(nullable = false)
  private String MessageContent;
}
