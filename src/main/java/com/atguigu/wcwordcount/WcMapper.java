package com.atguigu.wcwordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WcMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    IntWritable v = new IntWritable(1);
    Text k = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        String line = value.toString();
        String[] words = line.split(" ");
        for (String k : words) {
            this.k.set(k);
            context.write(this.k,v);

        }

    }
}
