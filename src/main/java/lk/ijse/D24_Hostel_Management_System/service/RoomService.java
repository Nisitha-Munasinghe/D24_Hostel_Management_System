package lk.ijse.D24_Hostel_Management_System.service;

import lk.ijse.D24_Hostel_Management_System.dto.RoomDto;
import lk.ijse.D24_Hostel_Management_System.dto.StudentDto;

public interface RoomService {

    String saveRoom(RoomDto roomDto);

    String updateRoom(RoomDto roomDto);


    String getGenerateRoomId();
}
