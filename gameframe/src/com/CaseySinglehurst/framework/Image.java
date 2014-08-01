package com.CaseySinglehurst.framework;

import com.CaseySinglehurst.framework.Graphics.ImageFormat;

public interface Image {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}