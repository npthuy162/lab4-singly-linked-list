/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.playlistmanager;

public class Playlist {

    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        System.out.println("Song added.");
    }

    public void removeSong(String title) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.song.getTitle().equalsIgnoreCase(title)) {
            if (currentNode == head) {
                currentNode = head.next;
            }

            head = head.next;
            size--;

            if (head == null) {
                tail = null;
                currentNode = null;
            }

            System.out.println("Song removed.");
            return;
        }

        Node previous = head;
        Node current = head.next;

        while (current != null) {
            if (current.song.getTitle().equalsIgnoreCase(title)) {

                previous.next = current.next;

                if (current == tail) {
                    tail = previous;
                }

                if (currentNode == current) {
                    currentNode = current.next;

                    if (currentNode == null) {
                        currentNode = head;
                    }
                }

                size--;
                System.out.println("Song removed.");
                return;
            }

            previous = current;
            current = current.next;
        }

        System.out.println("Song not found.");
    }

    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        }

        System.out.println("Now playing: " + currentNode.song);

        currentNode = currentNode.next;

        if (currentNode == null) {
            currentNode = head;
        }
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        System.out.println("\nPlaylist:");

        Node current = head;
        int number = 1;

        while (current != null) {
            System.out.println(number + ". " + current.song);
            current = current.next;
            number++;
        }

        System.out.println("Total songs: " + size);
    }
}
