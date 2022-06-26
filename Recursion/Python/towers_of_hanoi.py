def hanoi(disk, source, middle, destination):

    # Base Case
    # Move the smallest disk from source to destination
    if disk == 0:
        print(f'Move {disk} from {source} to {destination}')
        return

    # move all the disks above the current disk from source to middle using destination
    hanoi(disk-1, source, destination, middle)

    # move current disk from source to destination
    # not necessarily the largest disk but not the smallest one
    print(f'Move {disk} from {source} to {destination}')

    # move all the disks that are present in the middle rod to destination using source
    hanoi(disk-1, middle, source, destination)


hanoi(63, 'A', 'B', 'C')
