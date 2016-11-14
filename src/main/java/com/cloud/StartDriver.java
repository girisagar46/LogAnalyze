package com.cloud;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by linuxsagar on 10/21/16.
 */
public class StartDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        String input = "input/namenode.log";

        Configuration configuration = new Configuration();
        Job wordLineCatcher = Job.getInstance(configuration);

        FileInputFormat.setInputPaths(wordLineCatcher, input);
        FileOutputFormat.setOutputPath(wordLineCatcher,new Path("logOutput.csv"));

        wordLineCatcher.setInputFormatClass(TextInputFormat.class);
        wordLineCatcher.setOutputFormatClass(TextOutputFormat.class);

        wordLineCatcher.setOutputKeyClass(Text.class);
        wordLineCatcher.setOutputValueClass(Text.class);

        wordLineCatcher.setMapperClass(LogCatchMapper.class);

        wordLineCatcher.setJarByClass(StartDriver.class);
        wordLineCatcher.setJobName("Hadoop Error log analyzer");

        wordLineCatcher.waitForCompletion(true);
    }
}