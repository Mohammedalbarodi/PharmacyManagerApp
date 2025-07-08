@Entity(tableName = "prescriptions")
data class Prescription(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val customerId: Int,
    val doctorName: String,
    val issueDate: Long,
    val notes: String?
)
