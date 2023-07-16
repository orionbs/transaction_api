package fr.orionbs.transaction_manager_server.adapter.output.persistence.transaction.entity;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.account.entity.AccountEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.category.entity.CategoryEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.entity.FrequencyEntity;
import fr.orionbs.transaction_manager_server.adapter.output.persistence.owner.entity.OwnerEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "label", nullable = false, length = 20)
    private String label;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "milestone", nullable = false)
    private Timestamp milestone;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ToString.Exclude
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "frequency_id")
    @ToString.Exclude
    private FrequencyEntity frequency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private AccountEntity account;

    @Embedded
    private OwnerEntity owner;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TransactionEntity that = (TransactionEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

}
