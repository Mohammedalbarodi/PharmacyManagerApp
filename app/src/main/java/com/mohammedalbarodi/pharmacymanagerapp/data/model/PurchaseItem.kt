@Entity(tableName = "purchase_items")
data class PurchaseItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val invoiceId: Int,
    val medicineId: Int,
    val quantity: Int,
    val unitPrice: Double
)
