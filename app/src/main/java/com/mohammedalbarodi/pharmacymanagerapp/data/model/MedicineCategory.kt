@Entity(tableName = "categories")
data class MedicineCategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String?
)
