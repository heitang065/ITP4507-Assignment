package SourceCode.Factory;

import SourceCode.Command.*;
import SourceCode.ToyProduct.*;

import java.util.Vector;

public interface CmdFac {
    public abstract Cmd create() throws Exception;
    public abstract void setToys(Vector<ToyProduct> toys);
}
