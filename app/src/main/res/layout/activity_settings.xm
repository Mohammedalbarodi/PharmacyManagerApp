<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:background="#FFFFFF">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="الإعدادات"
            android:textSize="20sp"
            android:textStyle="bold"
            android:textColor="#039BE5"
            android:layout_marginBottom="20dp" />

        <Switch
            android:id="@+id/switchBiometric"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="تسجيل الدخول بالبصمة"
            android:textSize="16sp"
            android:textColor="#000000"
            android:padding="8dp" />

        <View
            android:layout_width="match_parent"
            android:layout_height="1dp"
            android:background="#BDBDBD"
            android:layout_marginVertical="12dp" />

        <Button
            android:id="@+id/btnBackup"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="نسخ احتياطي للبيانات"
            android:backgroundTint="#03A9F4"
            android:textColor="#FFFFFF" />

        <Button
            android:id="@+id/btnLogout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="تسجيل الخروج"
            android:layout_marginTop="16dp"
            android:backgroundTint="#E53935"
            android:textColor="#FFFFFF" />

    </LinearLayout>
</ScrollView>
