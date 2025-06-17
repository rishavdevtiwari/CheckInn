package checkinn.model;

import java.util.Date;
import java.util.List;

public class Booking {
    private int bookingId;
    private int roomId;
    private String roomType;
    private int userId;
        private double roomPrice;
    private int menuId;
    private int statusId;
    private int invoiceId;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private List<MenuItem> menuItems;
    private String clientName;

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }
    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }
    public String getRoomType() {
    return roomType;
}
public void setRoomType(String roomType) {
    this.roomType = roomType;
}
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getMenuId() { return menuId; }
    public void setMenuId(int menuId) { this.menuId = menuId; }
    public List<MenuItem> getMenuItems() {
    return menuItems;
}
public void setMenuItems(List<MenuItem> menuItems) {
    this.menuItems = menuItems;
}
    public double getRoomPrice() { return roomPrice; }
    public void setRoomPrice(double roomPrice) { this.roomPrice = roomPrice; }
    public int getStatusId() { return statusId; }
    public void setStatusId(int statusId) { this.statusId = statusId; }
    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }
    public Date getCheckInDate() { return checkInDate; }
    public void setCheckInDate(Date checkInDate) { this.checkInDate = checkInDate; }
    public Date getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }
    public double getTotalPrice() { return totalPrice; }
public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
}
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
}
