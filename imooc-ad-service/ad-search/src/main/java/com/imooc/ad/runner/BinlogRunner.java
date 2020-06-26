package com.imooc.ad.runner;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

public class BinlogRunner implements CommandLineRunner {

    private final BinaryLogClient client;
    @Autowired
    public BinlogRunner(BinaryLogClient client) {
        this.client = client;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Comming in BinlogRunner");
        client.connect();
    }
}
