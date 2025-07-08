@Entity(tableName = "returns")
data class Return(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val saleId: Int,
    val medicineId: Int,
    val quantityReturned: Int,
    val reason: String,
    val returnDate: Long
)
