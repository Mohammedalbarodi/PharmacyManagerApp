@Entity(tableName = "purchase_invoices")
data class PurchaseInvoice(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val supplierId: Int,
    val invoiceNumber: String,
    val purchaseDate: Long,
    val totalAmount: Double
)
