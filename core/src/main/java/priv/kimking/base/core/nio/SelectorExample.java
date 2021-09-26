package priv.kimking.base.core.nio;

import java.io.IOException;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 *
 * @author kim
 * @date 2021/9/24
 */
public class SelectorExample {

    public static void main(String[] args) throws IOException {
        // a channel that has connected successfully to another server is "connect ready"
        // A server socket channel which accepts an incoming connection is "accept" ready.
        // A channel that has data ready to be read is "read" ready
        // A channel that is ready for you to write data to it, is "write" ready.
        SelectableChannel channel = new SelectableChannel() {
            @Override
            public SelectorProvider provider() {
                return null;
            }

            @Override
            public int validOps() {
                return 0;
            }

            @Override
            public boolean isRegistered() {
                return false;
            }

            @Override
            public SelectionKey keyFor(Selector sel) {
                return null;
            }

            @Override
            public SelectionKey register(Selector sel, int ops, Object att) throws ClosedChannelException {
                return null;
            }

            @Override
            public SelectableChannel configureBlocking(boolean block) throws IOException {
                return null;
            }

            @Override
            public boolean isBlocking() {
                return false;
            }

            @Override
            public Object blockingLock() {
                return null;
            }

            @Override
            protected void implCloseChannel() throws IOException {

            }
        };
        // The Channel must be in non-blocking mode to be used with a Selector
        channel.configureBlocking(false);

        Selector selector = Selector.open();

        // This is an "interest set",
        // meaning what events you are interested in listening for in the Channel, via the Selector.
        channel.register(selector, SelectionKey.OP_READ);

        while (true) {
            // It returns immediately with whatever channels are ready
            int readyChannels = selector.selectNow();
            if (readyChannels == 0) {
                continue;
            }

            // access the ready channels
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                // The ready set is the set of operations the channel is ready for.
                if (key.isAcceptable()) {

                } else if (key.isConnectable()) {

                } else if (key.isReadable()) {

                } else if (key.isWritable()) {

                }
                keyIterator.remove();
            }
        }

    }
}
