package com.shopee.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shopee.MainActivity;
import com.shopee.R;

import com.shopee.notification.Notification;
import com.shopee.notification.NotificationAdapter;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    
    private View view;
    private MainActivity mainActivity;

    ArrayList<Notification> listCateNotifi;
    ArrayList<Notification> listNotifi;
    
    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notifications,container,false);

        initCateNotifi();
        
        initNotification();

        return view;
    }

    public void initCateNotifi() {
        RecyclerView rcv_cate_notifi = view.findViewById(R.id.rcv_cate_notifi);
        rcv_cate_notifi.setHasFixedSize(true);
        GridLayoutManager gird = new GridLayoutManager(mainActivity, 1, GridLayoutManager.VERTICAL, false);
        rcv_cate_notifi.setLayoutManager(gird);

        listCateNotifi = new ArrayList<>();

        listCateNotifi.add(new Notification(R.drawable.ic_promotion, "Khuyến mãi","Bình chọn 5 sao bởi người dùng",""));
        listCateNotifi.add(new Notification(R.drawable.ic_live_feed, "Shopee Live & Feed", "linhkiengiatot.net vừa đăng bài viết mới",""));
        listCateNotifi.add(new Notification(R.drawable.ic_wallet, "Cập nhật Ví", "Chúc mừng bạn! Thông tin đã được xác minh thành công",""));
        listCateNotifi.add(new Notification(R.drawable.ic_bell, "Hoạt động", "Chưa có hoạt động nào",""));
        listCateNotifi.add(new Notification(R.drawable.ic_shopping_bag, "Cập nhật Shopee", "Giá chỉ từ 19,590,000đ",""));
        listCateNotifi.add(new Notification(R.drawable.ic_now, "NowFood", "Đơn hàng của bạn tại Trà Sữa Xingfu Cha - Trần Cao Vân đã được Quốc Mai Văn giao thành công.",""));

        NotificationAdapter notificationAdapter = new NotificationAdapter(listCateNotifi, mainActivity, R.layout.item_category_notifi);
        rcv_cate_notifi.setAdapter(notificationAdapter);

    }
    public void initNotification() {
        RecyclerView rcv_notifi = view.findViewById(R.id.rcv_notifi);
        rcv_notifi.setHasFixedSize(true);
        GridLayoutManager gird = new GridLayoutManager(mainActivity, 1, GridLayoutManager.VERTICAL, false);
        rcv_notifi.setLayoutManager(gird);

        listNotifi = new ArrayList<>();

        listNotifi.add(new Notification(R.drawable.product7, "Xác Nhận Đã Nhận Hàng","Vui lòng chọn \"Đã Nhận Được Hàng\" cho đơn 201026B6HU0CPH , nếu bạn hài lòng với tất cả sản phẩm và không có nhu cầu Trả hàng / Hoàn tiền. Đánh giá ngay và nhận 100 Xu.",""));
        listNotifi.add(new Notification(R.drawable.product7, "Chia sẻ nhận xét về sản phẩm", "Đơn hàng 201019Q6BPM8E6 đã hoàn thành. Bạn hãy đánh giá sản phẩm trước ngày 11-11-2020 để nhận 100 xu và giúp người dùng khác hiểu hơn về sản phẩm nhé!",""));
        listNotifi.add(new Notification(R.drawable.nhanxet, "Đơn đã hoàn thành", "Đơn hàng của bạn 2020101714182114804 đã hoàn thành.",""));
        listNotifi.add(new Notification(R.drawable.product8, "Chia sẻ nhận xét về sản phẩm", "Đơn hàng 20100179P27WC5 đã hoàn thành. Bạn hãy đánh giá sản phẩm trước ngày 30-10-2020 để nhận 100 xu và giúp người dùng khác hiểu hơn về sản phẩm nhé!o",""));
        listNotifi.add(new Notification(R.drawable.product2, "Hoàn tiền vào Ví AirPay thành công", "Yêu cầu hoàn tiền cho đơn hàng 2010138J9WKPP0 được chấp nhận. Số tiền hoàn lại ₫29.440 sẽ được chuyển vào Ví AirPay của bạn.",""));
        listNotifi.add(new Notification(R.drawable.product3, "Xác nhận đã thanh toán", "Thanh toán cho đơn hàng 2010138J9WKPP0 thành công. Vui lòng kiểm tra thời gian nhận hàng dự kiến trong phần chi tiết đơn hàng nhé!",""));

        NotificationAdapter notifiAdapter = new NotificationAdapter(listNotifi, mainActivity, R.layout.item_notification);
        rcv_notifi.setAdapter(notifiAdapter);

    }
}
