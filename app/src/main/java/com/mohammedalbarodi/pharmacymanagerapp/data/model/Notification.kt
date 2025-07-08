@Entity(tableName = "notifications")
data class Notification(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val type: String,
    val message: String,
    val createdAt: Long,
    val isRead: Boolean
)
