package com.sjsu.umlgenerator.parser.model;

import java.io.File;

public class DirectoryIterator {
    public interface FileHandler {
	void handle(int level, String path, File file);
    }

    public interface Filter {
	boolean interested(int level, String path, File file);
    }

    private final FileHandler fileHandler;
    private final Filter filter;

    public DirectoryIterator(Filter filter, FileHandler fileHandler) {
	this.filter = filter;
	this.fileHandler = fileHandler;
    }

    public void explore(File root) {
	explore(0, "", root);
    }

    private void explore(int level, String path, File file) {
	if (file.isDirectory()) {
	    for (final File child : file.listFiles()) {
		explore(level + 1, path + "/" + child.getName(), child);
	    }
	} else {
	    if (filter.interested(level, path, file)) {
		fileHandler.handle(level, path, file);
	    }
	}
    }



}