@Entity(tableName = "sale_items")
data class SaleItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val saleId: Int,
    val medicineId: Int,
    val quantity: Int,
    val unitPrice: Double,
    val totalPrice: Double
)
