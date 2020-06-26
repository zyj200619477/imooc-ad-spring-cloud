package com.imooc.ad.service;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

public class BinlogServiceTest {
    /*
    Write---------
WriteRowsEventData{tableId=87, includedColumns={0, 1, 2, 3, 4, 5, 6, 7}, rows=[
    [10, 10, plan, 1, Mon Dec 31 18:00:00 CST 2018, Mon Dec 31 18:00:00 CST 2018, Mon Dec 31 18:00:00 CST 2018, Mon Dec 31 18:00:00 CST 2018]
]}
     */

    public static void main(String[] args) throws Exception {

        BinaryLogClient client = new BinaryLogClient(
                "127.0.0.1",
                3306,
                "root",
                "zyjdhr96130"
        );

//        client.setBinlogFilename("binlog.000001");
//        client.setBinlogPosition();
        client.registerEventListener(event -> {
            EventData data = event.getData();
            if (data instanceof UpdateRowsEventData) {
                System.out.println("Update---------");
                System.out.println(data.toString());
            } else if(data instanceof WriteRowsEventData) {
                System.out.println("Write---------");
                System.out.println(data.toString());
            } else if(data instanceof DeleteRowsEventData) {
                System.out.println("Delete---------");
                System.out.println(data.toString());
            }
        });

        client.connect();
    }
}
