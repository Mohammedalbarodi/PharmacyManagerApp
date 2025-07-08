@Entity(tableName = "prescription_items")
data class PrescriptionItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val prescriptionId: Int,
    val medicineId: Int,
    val dosage: String,
    val duration: String
)
