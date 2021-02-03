package jm.stockx.dto;

import lombok.*;
import org.joda.money.Money;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BuyingInfoPostDto {

    @NotNull
    private LocalDateTime buyingTimeStamp;

    @Positive(message = "Цена должна быть положительной")
    @NotNull
    private Money buyingPrice;

//    private Set<Item> boughtItems;

//    private Set<PaymentInfo> paymentsInfo;

//    @NotNull
//    private Status status;

//    public BuyingInfoPostDto(BuyingInfo buyingInfo) {
//        this.buyingTimeStamp = buyingInfo.getBuyingTimeStamp();
//        this.buyingPrice = buyingInfo.getBuyingPrice();
//        this.boughtItems = buyingInfo.getBoughtItems();
//        this.paymentsInfo = buyingInfo.getPaymentsInfo();
//        this.status = buyingInfo.getStatus();
//    }
}
