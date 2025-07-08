@Entity(tableName = "stock_transactions")
data class StockTransaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val medicineId: Int,
    val type: String, // "add", "remove", "return"
    val quantity: Int,
    val date: Long,
    val reference: String?
)
