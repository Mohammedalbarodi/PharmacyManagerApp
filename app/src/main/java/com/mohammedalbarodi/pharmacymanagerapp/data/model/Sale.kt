@Entity(tableName = "sales")
data class Sale(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val invoiceNumber: String,
    val saleDate: Long,
    val customerId: Int?,
    val totalAmount: Double,
    val paymentMethodId: Int
)
