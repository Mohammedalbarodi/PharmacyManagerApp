@Database(
    entities = [
        Medicine::class,
        MedicineCategory::class,
        Sale::class,
        SaleItem::class,
        Return::class,
        Supplier::class,
        PurchaseInvoice::class,
        PurchaseItem::class,
        Customer::class,
        Prescription::class,
        PrescriptionItem::class,
        Expense::class,
        User::class,
        Notification::class,
        BackupLog::class,
        StockTransaction::class,
        PaymentMethod::class,
        Settings::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // DAO interfaces
    abstract fun medicineDao(): MedicineDao
    abstract fun saleDao(): SaleDao
    abstract fun returnDao(): ReturnDao
    abstract fun supplierDao(): SupplierDao
    abstract fun purchaseDao(): PurchaseDao
    abstract fun customerDao(): CustomerDao
    abstract fun prescriptionDao(): PrescriptionDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun userDao(): UserDao
    abstract fun notificationDao(): NotificationDao
    abstract fun backupDao(): BackupLogDao
    abstract fun stockDao(): StockTransactionDao
    abstract fun paymentDao(): PaymentMethodDao
    abstract fun settingsDao(): SettingsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pharmacy.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
