@Entity(tableName = "payment_methods")
data class PaymentMethod(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String // مثلاً: "نقدًا", "بطاقة", "آجل"
)
