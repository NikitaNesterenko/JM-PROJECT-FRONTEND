package jm.stockx.model.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

/* Таблица хранит данные для покупки: карту и адрес доставки */
public class PaymentInfo {
    private Long id;

    private String cardNumber;

    private String cardExpiresDate;

    private String cvv;

    private String firstName;

    private String lastName;

    private String country;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String phoneNumber;
}
