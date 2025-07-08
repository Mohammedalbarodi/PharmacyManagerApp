@Entity(tableName = "medicines")
data class Medicine(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val brand: String?,
    val categoryId: Int?,
    val quantity: Int,
    val price: Double,
    val expiryDate: Long,
    val barcode: String?,
    val location: String?,
    val notes: String?
)
